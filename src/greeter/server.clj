(ns greeter.server
  (:require
   [com.stuartsierra.component :as component]
   [ring.component.jetty :as jetty]))


(defrecord Handler [handler-fn]
  component/Lifecycle
  (start [this]
    (let [handler (:handler-fn this)]
      (assoc this :handler (fn [req]
                             (handler (assoc req :component this))))))
  (stop [this] (assoc this :handler nil)))

(defn create [handler-fn dependencies conf]
  (let [handler-key (keyword (:name conf) "handler")
        server-key (keyword (:name conf) "server")]
    {handler-key (component/using (map->Handler {:handler-fn handler-fn})
                                  dependencies)
     server-key (component/using (jetty/jetty-server conf)
                                 {:app handler-key})}))

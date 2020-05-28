(ns greeter.core
  (:gen-class)
  (:require
    [com.stuartsierra.component :as component]
    [duckula.component.basic-monitoring :as monitoring]
    [duckula.handler]
    [greeter.server :as server]))


(defn handler [{:keys [body]}]
  {:status 200
   :body {:message (str "hello, " (:name body))}})

(def api-config
  {:name "test-api"
   :endpoints
   {"/hello"
    {:handler handler
     :request {:type "record"
               :name "hello.Request"
               :fields [{:name "name"
                         :type "string"}]}
     :response {:type "record"
                :name "hello.Response"
                :fields [{:name "message"
                          :type "string"}]}}}})


(def api (duckula.handler/build api-config))


(def system
  (merge
    (server/create api
                   [:monitoring]
                   {:port 9100})
    {:monitoring monitoring/basic}))


(defn start!
  []
  (-> system
      component/map->SystemMap
      component/start))


(def stop! component/stop)


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (start!))

(defproject greeter "0.1.0-SNAPSHOT"
  :description "Greeter service"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [nomnom/duckula "0.6.0-SNAPSHOT"]

                 ;; logging
                 [org.clojure/tools.logging "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"]

                 ;; Web serving things

                 [ring-jetty-component "0.3.1"
                  :exclude [ring/ring-codec
                            org.eclipse.jetty/jetty-server]]
                 [org.eclipse.jetty/jetty-server "9.4.21.v20190926"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.5.0"]]
  :main ^:skip-aot greeter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

(ns hs.core
  (:require
    [ring.middleware.reload :refer [wrap-reload]]
    [ring.adapter.jetty :refer [run-jetty]]
    [toucan.db :as db]
    [toucan.models :as models]
    [ring.util.http-response :refer [ok]]
    [compojure.api.sweet :refer [api context GET routes]]
    [hs.user :refer [user-routes]])
  (:gen-class))


(def db-spec
  {:dbtype   "postgres"
   :dbname   "hs"
   :user     "postgres"
   :password "postgres"})

(def app (user-routes))

(def reloadable (wrap-reload #'app))

(defn -main
  [& _]
  (run-jetty reloadable {:port 3000}))

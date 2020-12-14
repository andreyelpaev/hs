(ns hs.user)

(require '[schema.core :as s])

(require '[toucan.db :as db])
(require '[clojure.string :as str])

(require '[ring.util.http-response :refer [created ok]])
(require '[compojure.api.sweet :refer :all])
(require '[hs.models.user :refer [User]])

(def non-blank? (complement str/blank?))

(s/defschema UserRequestSchema {
                                :firstname (s/constrained s/Str non-blank?)
                                })

(defn id->created [id] (created (str "/users/" id) {:id id}))

(defn create-user-handler [create-user-req]
  (->> (create-user-req)
       :id
       id->created))


(defn user-routes
  [] (api
       {:swagger
        {:ui   "/api/docs"
         :spec "/swagger.json"
         :data {:info
                {:title       "HS API"
                 :description "Health Samurai Test"}
                :tags [{:name "/api/users", :description "Users API"}]
                :consumes ["application/json"]
                :produces ["application/json"]}}}
       (context "/api" []
         :tags ["api"]
         (POST "/users" []
           :return UserRequestSchema
           :body [user UserRequestSchema]
           :summary "Save user"
           (id->created 2))
         )))

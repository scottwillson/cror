(ns cror.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cror.views.home :as views/home]))

(defroutes app-routes
  (GET "/" [] views/home/show-html)
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

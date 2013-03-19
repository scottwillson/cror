(ns cror.test.handler
  (:use clojure.test
        ring.mock.request  
        cror.handler)
  (:require [clj-webdriver.taxi :refer :all]))

(def ^:private browser-count (atom 0))

(defn browser-up
    "Start up a browser if it's not already started."
    []
    (when (= 1 (swap! browser-count inc))
          (set-driver! {:browser :firefox})
          (implicit-wait 60000)))

(defn browser-down
    "If this is the last request, shut the browser down."
    [& {:keys [force] :or {force false}}]
    (when (zero? (swap! browser-count (if force (constantly 0) dec)))
          (quit)))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (re-find #"Home" (:body response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

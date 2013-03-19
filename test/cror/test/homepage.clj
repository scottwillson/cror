(ns cror.test.homepage
  (:require [clj-webdriver.taxi :refer :all]
            [clojure.test :refer :all])

(deftest home-page
  (browser-up)
  (browser-down))


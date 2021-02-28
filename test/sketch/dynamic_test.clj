(ns sketch.dynamic-test
  (:require [clojure.test :refer :all])
  (:require [sketch.dynamic :refer [draw-circles]]))

(deftest draw-circles-test
  (draw-circles (fn [x y rad0 rad1] (println (str "X: " x ", Y: " y ", radius: " rad0))) 900 600 200))

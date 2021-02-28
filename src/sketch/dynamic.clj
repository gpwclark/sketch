(ns sketch.dynamic
  (:require [quil.core :refer :all]
            [quil.core :as q])
  (:use [clojure.pprint]))

(defn draw-circles [x y radius]
  (ellipse x y (* 2 radius) ( * 2 radius))
  (when (> radius 2)
    (let [new-radius (/ radius 2)]
       (do
         (draw-circles (+ x new-radius) y new-radius)
         (draw-circles (- new-radius x) y new-radius)
       ))))

(defn setup []
  ; Set color mode to HSB (HSV) instead of default RGB.
  (color-mode :hsb 360 100 100 1.0)
  (background 100 100 200)
  (draw-circles 450 450 450))

(defn draw []
  (no-loop))
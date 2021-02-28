(ns sketch.dynamic
  (:require [quil.core :refer :all]
            [quil.core :as q]
            [clojure.pprint :as pprint])
  (:use [clojure.pprint]))

(defn draw-circles [fun x y radius]
  (fill (mod x 255) (mod y 255) (mod (* radius radius) 255) (+ 80 (mod (* x y) 54)))
  (fun x y (* 2 radius) ( * 2 radius))
  (when  (> radius 2)
    (let [new-radius (/ radius 2)
          actions (list {:x (+ x (* 2 radius)) :y y :radius new-radius}
                        {:x (- x (* 2 radius)) :y y :radius new-radius}
                        {:x x :y (+ y (* 2 radius)) :radius new-radius}
                        {:x x :y (- y (* 2 radius)) :radius new-radius})]
      (doall (map (fn [circle] (let [{x :x y :y radius :radius} circle]
                           (draw-circles fun x y radius))) (random-sample 0.8 actions))))))

(defn setup []
  (background 255 255 255)
  (draw-circles ellipse 900 600 200)
  (draw-circles ellipse 450 300 200)
  (draw-circles ellipse 1350 300 200)
  (draw-circles ellipse 450 900 200)
  (draw-circles ellipse 1350 900 200))

(defn draw []
  (save "cool-image.png")
  (no-loop))
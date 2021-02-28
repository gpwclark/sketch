(ns sketch.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [sketch.dynamic :as dynamic])
  (:gen-class))

(q/defsketch example
             :title "Sketch"
             :setup dynamic/setup
             :draw dynamic/draw
             :size [1800 1200]
             ;;:size [900 900]
             ;;:features [:keep-on-top]
             ; fun-mode.
             ;;:middleware [m/fun-mode]
             )

(defn refresh []
  (use :reload 'sketch.dynamic)
  (.loop example))

(refresh)


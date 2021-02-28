(ns sketch.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [sketch.dynamic :as dynamic])
  (:gen-class))

(q/defsketch example
             :title "Sketch"
             :setup dynamic/setup
             :draw dynamic/draw
             :size [1800 1200])

(defn refresh []
  (use :reload 'sketch.dynamic)
  (.loop example))


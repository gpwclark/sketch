(ns sketch.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [sketch.dynamic :as dynamic])
  (:gen-class))

(q/defsketch example
             :title "Sketch"
             :setup dynamic/setup
             :draw dynamic/draw
             ;;:update dynamic/update
             ;; :size [1800 1200] # postcard 4"x6" at 300dpi. h/we final image needs a .25" border so
             ;; the final size should be [1875 1275]
             ;; 900x900 is quicker to generate
             :size [900 900]
             ;;:features [:keep-on-top]
             ; This sketch uses functional-mode middleware.
             ; Check quil wiki for more info about middlewares and particularly
             ; fun-mode.
             ;;:middleware [m/fun-mode]
             )

(defn refresh []
  (use :reload 'sketch.dynamic)
  (.loop example))


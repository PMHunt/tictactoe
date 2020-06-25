(ns tictactoe.views
  (:require
   [re-frame.core :as re-frame]
   [tictactoe.subs :as subs]
   ))

(defn grid []
  [:table
   (for [y (range 3)]
     [:tr
      (for [x (range 3)]
        [:td "CELL"])])
   ])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        db (re-frame/subscribe [::subs/db] )]
    [:div
     [:h1 "Hello hello from tictactoe starring " @name]
     [grid]
     [:div
      (pr-str @db)]
     ]))

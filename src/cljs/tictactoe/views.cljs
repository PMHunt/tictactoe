(ns tictactoe.views
  (:require
   [re-frame.core :as re-frame]
   [tictactoe.subs :as subs]
   ))

(defn cell [x y]
  (let [c (re-frame/subscribe [::cell x y])]
    (fn []
      (case @c
        :x [:span "X"]
        :o [:span "O"]
        [:button {:on-click #()}
         " "]))))

(defn grid []
  [:table
   (for [y (range 3)]
     [:tr
      (for [x (range 3)]
        [:td [::cell x y]])])
   ])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        db (re-frame/subscribe [::subs/db] )]
    [:div
     [:h1 "Hello hello from tictactoe starring " @name]
     [grid]
     [:button {:on-click #(re-frame/dispatch [::initialize-db])} "RESET"] ;;
     [:div
      (pr-str @db)] ;; show subscription to db via view for debugging
     ]))

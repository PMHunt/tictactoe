(ns tictactoe.views
  (:require
   [re-frame.core :as re-frame]
   [tictactoe.subs :as subs]
   ))

(defn cell [x y]
  (let [c (re-frame/subscribe [::subs/cell x y])]
    (fn []
      (case @c
        :x [:span "X"]
        :o [:span "O"]
        [:button {:on-click  #(re-frame/dispatch [:move x y]) } ;
         "move"]))))

(defn grid []
  [:table
   [:tbody
    (for [y (range 3)] ^{:key y}
      [:tr
       (for [x (range 3)] ^{:key x}
         [:td ; {:style {:width 30 :height 30 :text-align :center}}
          [cell x y]])])]]) ; was  [cell x y] with issues

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        db (re-frame/subscribe [::subs/db] )]
    [:div
     [:h1 "Hello  from tictactoe starring " @name]
     [grid]
     [:button {:on-click #(re-frame/dispatch [:initialize-db])} "RESET"] ;;
     [:div
      (pr-str @db)] ;; show subscription to db via view for debugging
     ]))

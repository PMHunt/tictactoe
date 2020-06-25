(ns tictactoe.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub ;; subscribe to db state so I can see what's going on via view
 ::db
 (fn [db]
   db))

(re-frame/reg-sub
 ::cell
 (fn [db [_ x y]]
   (reaction (get-in db [:board x y]))))

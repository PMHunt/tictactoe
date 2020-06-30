(ns tictactoe.events
  (:require
   [re-frame.core :as re-frame]
   [tictactoe.db :as db]
   ))

(re-frame/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

(defn rotate [turn]
  (if (= :x turn)
    :o
    :x))

(re-frame/reg-event-db
 :move
 (fn [db [_ x y]]
   (let [turn (:turn db)]
     (-> db
         (assoc :turn (rotate turn))
         (assoc-in [:board [x y]] turn)))))

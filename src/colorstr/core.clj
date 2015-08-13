(ns colorstr.core)

(def ANSI-ESCAPE-CODES
  {:strikethrough-off  "[29m"
   :strikethrough      "[9m"
   :inverse-off        "[27m"
   :inverse            "[7m"
   :underline-off      "[24m"
   :underline          "[4m"
   :blink-slow         "[5m"
   :bright             "[1m"
   :reset              "[0m"

   :default            "[39m"
   :white              "[37m"
   :black              "[30m"
   :red                "[31m"
   :green              "[32m"
   :blue               "[34m"
   :yellow             "[33m"
   :megenta            "[35m"
   :cyan               "[36m"

   :bg-default         "[49m"
   :bg-white           "[47m"
   :bg-black           "[40m"
   :bg-red             "[41m"
   :bg-green           "[42m"
   :bg-blue            "[44m"
   :bg-yellow          "[43m"
   :bg-megenta         "[45m"
   :bg-cyan            "[46m"
   })

;This method transform color code to ansi-escape-code,
;Example: -> (ansi :red)  
;         => "\u001b[31m"
(defn ansi [code]
  (str \u001b (get ANSI-ESCAPE-CODES code (:reset ANSI-ESCAPE-CODES))))

;Ignore the escape-code in text like '\u001b[39m text \u001b[0m'
(defn raw [s]
  (clojure.string/replace s "\u001b" "\\u001b"))

;-> (style "text" :red :bright)
;=> "\u001b[31m\u001b[1mtext\u001b[0m"
(defn style [s & codes]
  (str (apply str (map ansi codes)) (raw s) (ansi :reset)))

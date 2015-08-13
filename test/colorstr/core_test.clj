(ns colorstr.core-test
  (:require [clojure.test :refer :all]
            [colorstr.core :refer :all]))

(deftest single-style
  (testing "Testing single-style"
    (is (= "\u001b[31mtext\u001b[0m" (style "text" :red)))))
(deftest comp-style
  (testing "Testing comp-style"
    (is (= "\u001b[31m\u001b[1mtext\u001b[0m" (style "text" :red :bright)))))

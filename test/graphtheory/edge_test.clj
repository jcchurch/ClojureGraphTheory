(ns graphtheory.edge-test)
(require '[clojure.test :refer :all])
(require '[graphtheory.model.vertex :as vertex])
(require '[graphtheory.model.edge :as edge])

(deftest MakeAnEdgeOfTwoVertices
  (testing "Make an edge of two vertices"
    (is (= {:first {:name "a", :type :vertex}, :second {:name "b", :type :vertex}, :weight 1, :type :edge} (edge/make (vertex/make "a") (vertex/make "b") 1)))
  )
)

(deftest MadeEdgeIsAnEdge
  (testing "Made edge is an edge"
    (is (edge/is (edge/make (vertex/make "a") (vertex/make "b") 1)))
  )
)

(deftest VertexAIsInEdgeAB
  (testing "Vertex A is in Edge AB"
    (is (edge/contains (edge/make (vertex/make "a") (vertex/make "b") 1) (vertex/make "a")))
  )
)

(deftest VertexBIsInEdgeAB
  (testing "Vertex B is in Edge AB"
    (is (edge/contains (edge/make (vertex/make "a") (vertex/make "b") 1) (vertex/make "b")))
  )
)

(deftest VertexCIsNotInEdgeAB
  (testing "Vertex C is not in Edge AB"
    (is (not (edge/contains (edge/make (vertex/make "a") (vertex/make "b") 1) (vertex/make "c"))))
  )
)


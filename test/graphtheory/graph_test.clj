(ns graphtheory.graph-test)
(require '[clojure.test :refer :all])
(require '[graphtheory.model.vertex :as vertex])
(require '[graphtheory.model.edge :as edge])
(require '[graphtheory.model.graph :as graph])

(def aVertex (vertex/make "a"))
(def bVertex (vertex/make "b"))
(def cVertex (vertex/make "c"))

(def abEdge (edge/make aVertex bVertex 4))
(def bcEdge (edge/make bVertex cVertex 5))
(def acEdge (edge/make aVertex cVertex 6))

(def aGraph (graph/make [abEdge bcEdge acEdge]))
(def sGraph (graph/make [abEdge]))
(def eGraph (graph/make []))

(deftest aGraphIsAGraph
  (testing "aGraph is a graph"
    (is (graph/is aGraph))
  )
)

(deftest aGraphHas3Vertices
  (testing "aGraph has 3 vertices"
    (is (= 3 (count (aGraph :vertices))))
  )
)

(deftest aGraphHas3Edges
  (testing "aGraph has 3 edges"
    (is (= 3 (count (aGraph :edges))))
  )
)

(deftest sGraphIsAGraph
  (testing "sGraph is a graph"
    (is (graph/is sGraph))
  )
)


(deftest sGraphHas2Vertices
  (testing "sGraph has 2 vertices"
    (is (= 2 (count (sGraph :vertices))))
  )
)

(deftest sGraphHas1Edges
  (testing "sGraph has 1 edges"
    (is (= 1 (count (sGraph :edges))))
  )
)

(deftest eGraphIsAGraph
  (testing "eGraph is a graph"
    (is (graph/is eGraph))
  )
)

(deftest eGraphHas0Vertices
  (testing "eGraph has 0 vertices"
    (is (= 0 (count (eGraph :vertices))))
  )
)

(deftest eGraphHas3Edges
  (testing "eGraph has 0 edges"
    (is (= 0 (count (eGraph :edges))))
  )
)


(ns graphtheory.model.graph
  "Library for building an undirected weighted graph."
)
(require '[graphtheory.model.edge :as edge])

(defn is
  "Is this a graph?"
  [graph]
  (= :graph (graph :type))
)

(defn edge-to-tuple
  "Given an edge, converts it to a tuple"
  [edge]
  (if (edge/is edge)
    [(edge/firstName edge),
     (edge/secondName edge),
     (edge :weight)
    ]
    :fail
  )
)

(defn add-edge
  "Given a graph and an edge, adds the edge and both vertices to the graph."
  [graph edge]
  (if (and (is graph) (edge/is edge))
    {:type :graph,
     :vertices (conj
       (graph :vertices)
       (edge/firstName edge)
       (edge/secondName edge)),
     :edges (conj (graph :edges) (edge-to-tuple edge))
    }
    :fail
  )
) 

(defn make-complete
  "Given a set of vertices, makes a complete graph."
  [vertices]
  (

  )
)

(defn make
  "Make a new graph"
  [edges]
  (reduce
    add-edge
    {:type :graph, :vertices (set '()), :edges '()}
    edges
  )
)

(defn vertex-neighbors
  "Given a graph and a vertexname, returns the neighbors."
  [graph vertexname]
  (if (is graph)
    (filter
      (fn [neighbor] (not= "" neighbor))
      (map
        (fn [[fst,snd,_]]
           (if (= vertexname fst) snd
             (if (= vertexname snd) fst
               ""
             )
           )
        )
        (graph :edges)
      )
    )
    :fail
  )
)

(defn vertex-degree
  "Given a graph and a vertexname, computes the degree."
  [graph vertexname]
  (if (is graph)
    (count (vertex-neighbors graph vertexname))
    :fail
  )
)

(defn edge-sum
  "Computes the sum of the edges in a graph"
  [graph]
  (if (is graph)
    (apply + (map (fn [[_,_,weight]] weight) (graph :edges)))
    :fail
  )
)

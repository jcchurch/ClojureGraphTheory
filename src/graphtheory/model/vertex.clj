(ns graphtheory.model.vertex
  "Library for the creation of vertices."
)

(defn make
  "Make a new vertex"
  [name]
  {:name name, :type :vertex}
)

(defn is
  "Is this a vertex?"
  [vertex]
  (= :vertex (vertex :type))
)

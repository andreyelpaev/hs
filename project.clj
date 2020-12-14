(defproject hs "0.1.0"
  :description "FIXME: write description"
  :url "http://github.com/andreyelpaev"
  :license {:name "MIT"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"],
                                        ; Web
                 [prismatic/schema "1.1.9"]
                 [metosin/compojure-api "2.0.0-alpha31"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [ring/ring-devel "1.8.2"]
                 ; Database
                 [toucan "1.1.9"]
                 [org.postgresql/postgresql "42.2.4"]]
  :main ^:skip-aot hs.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})

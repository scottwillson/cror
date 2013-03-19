(ns cror.views.home
  (:use compojure.core)
  (:use hiccup.core
        hiccup.page))

(def show-html
  (html5
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
      [:title "Home"]
      (include-css "http://twitter.github.com/bootstrap/assets/css/bootstrap.css")
      (include-css "http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css")]
      [:style "body { padding-top: 60px; }"]
    [:body
      [:div.navbar.navbar-inverse.navbar-fixed-top
        [:div.navbar-inner
          [:div.container-fluid
            [:div.nav-collapse.collapse
              [:button.btn.btn-navbar
                [:span.icon-bar]
                [:span.icon-bar]
                [:span.icon-bar]]
               [:a {:class "brand" :href "/"} "Racing on Rails"]]]]]
      [:div.container-fluid
        [:div.row-fluid
          [:div.span12
           [:h1 "Racing on Rails"]]]]]))

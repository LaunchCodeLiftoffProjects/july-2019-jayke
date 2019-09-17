(function(d, t, e, m){

    // Async Rating-Widget initialization.
    window.RW_Async_Init = function(){

        RW.init({
            huid: "442080",
            uid: "e44f2f228b535a0901cef403a3ae6140",
            source: "website",
            options: {
                "advanced": {
                    "layout": {
                        "align": {
                            "hor": "center",
                            "ver": "bottom"
                        },
                        "lineHeight": "12px"
                    },
                    "font": {
                        "size": "12px"
                    }
                },
                "size": "large",
                "style": "quartz_blue",
                "isDummy": false
            }
        });
        RW.render();
    };
        // Append Rating-Widget JavaScript library.
    var rw, s = d.getElementsByTagName(e)[0], id = "rw-js",
        l = d.location, ck = "Y" + t.getFullYear() +
        "M" + t.getMonth() + "D" + t.getDate(), p = l.protocol,
        f = ((l.search.indexOf("DBG=") > -1) ? "" : ".min"),
        a = ("https:" == p ? "secure." + m + "js/" : "js." + m);
    if (d.getElementById(id)) return;
    rw = d.createElement(e);
    rw.id = id; rw.async = true; rw.type = "text/javascript";
    rw.src = p + "//" + a + "external" + f + ".js?ck=" + ck;
    s.parentNode.insertBefore(rw, s);
    }(document, new Date(), "script", "rating-widget.com/"));
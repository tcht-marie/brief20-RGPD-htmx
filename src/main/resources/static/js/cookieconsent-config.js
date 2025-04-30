import "https://cdn.jsdelivr.net/gh/orestbida/cookieconsent@3.1.0/dist/cookieconsent.umd.js";

CookieConsent.run({
    categories: {
        necessary: {
            enabled: true, // this category is enabled by default
            readOnly: true, // this category cannot be disabled
        },
    },
    language: {
        default: "fr",
        translations: {
            fr: {
                "consentModal": {
                    "title": "Consentements",
                    "description": "Nous utilisons les cookies",
                    "acceptAllBtn": "Tout accepter",
                    "acceptNecessaryBtn": "Tout rejeter",
                    "showPreferencesBtn": "Configurer mes préférences"
                },
                "preferencesModal": {
                    "title": "Préférences de cookies",
                    "acceptAllBtn": "Tout accepter",
                    "acceptNecessaryBtn": "Tout rejeter",
                    "savePreferencesBtn": "Sauvegarder mes préférences",
                    "closeIconLabel": "Fermer",
                    "sections": [
                        {
                            "title": "Utilisation des cookies",
                            "description": "Nous utilisons des cookies pour assurer les fonctionnalités de base du site Web et pour améliorer votre expérience en ligne."
                        },
                        {
                            "title": "Cookies strictement nécessaires",
                            "description": "Ces cookies sont essentiels au bon fonctionnement du site web. Sans eux, le site ne fonctionnerait pas correctement.Nous avons besoin de collecter et stocker vos informations personnelles telles que votre adresse mail, votre nom complet, votre mot de passe chiffré, votre photo de profil si vous en télécharger une, votre les informations de votre profil, votre rôle et votre identifiant de connection. Nous stockons également les notifications que vous recevez ainsi que les rendez-vous pris. Enfin, les documents que vous importez sur le site sont aussi stockés.",
                            "linkedCategory": "necessary"
                        },
                        {
                            "title": "Plus d'informations",
                            "description": "Pour toute question relative à notre politique en matière de cookies et à vos choix, veuillez <a class=\"cc-link\">nous contacter</a>."
                        }
                    ]
                }
            }
        },
    },
});
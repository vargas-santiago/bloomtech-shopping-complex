module.exports = {
    getUsername: function() {
        const username = sessionStorage.getItem('username');

        if (username === 'undefined' || !username) {
            return null;
        } else {
            return JSON.parse(username);
        }
    },

    getUserId: function() {
        const userId = sessionStorage.getItem('userId');

        if (userId === 'undefined' || !userId) {
            return null;
        } else {
            return JSON.parse(userId);
        }
    },

    getEmail: function() {
        const email = sessionStorage.getItem('email');

        if (email === 'undefined' || !email) {
            return null;
        } else {
            return JSON.parse(email);
        }
    },

    getFavorites: function() {
        const favorites = sessionStorage.getItem('favorites');

        if (favorites === 'undefined' || !favorites) {
            return null;
        } else {
            return JSON.parse(favorites);
        }
    },

    setUserSession: function(username, userId, email, favorites) {
        sessionStorage.setItem('username', JSON.stringify(username));
        sessionStorage.setItem('userId', JSON.stringify(userId));
        sessionStorage.setItem('email', JSON.stringify(email));
        sessionStorage.setItem('favorites', JSON.stringify(favorites));
    },

    resetUserSession: function() {
        sessionStorage.removeItem('userId');
        sessionStorage.removeItem('username');
        sessionStorage.removeItem('email');
        sessionStorage.removeItem('favorites');
    }
}

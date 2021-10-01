from mysqlconnection import connectToMySQL

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data ['last_name']
        self.email_address = data['email_address']
        self.created_at = data['created_at']

@classmethod
def get_all (cls):
    query = "SELECT * FROM users;"
    results= connectToMySQL('user_dashboard').query_db(query)
    users= []

    for user in results:
        user.append(cls (user))
        return users

@classmethod
def save(cls, data ):
    query = "INSERT INTO users ( first_name ,last_name, email_address, created_at) VALUES ( %(first_name)s, %(last_names)s, %(email_address)s, NOW() );"
    return connectToMySQL('user_dashboard').query_db( query, data )
class WelcomeController < ApplicationController

  def index
    current_uri = request.original_url

    @welcome =
        {
            name: 'DivulgaAPI',
            for: 'Divulgarejo',
            current_version: {
                version: 'v1',
                codename: 'MasterPica',
                status: 'development'
            },
            who: [{ name: 'Bruno Casali', contact: '@brunoocasali' }],
            start:
                {
                    docs: 'no docs, for while',
                    why: 'Everyone wants to come back to the local store'
                }
        }
    respond_with @welcome
  end
end

class WelcomeController < ApplicationController

  def index
    current_uri = request.original_url

    @welcome =
        {
            name: 'ColdAPI',
            for: 'QuebraGelo',
            current_version: {
                version: 'v1',
                codename: 'Apollo',
                status: 'development'
            },
            who: [{ name: 'Bruno Casali', contact: '@brunoocasali' }],
            start:
                {
                    docs: 'no docs, for while',
                    why: 'Are not you tired of sameness?',
                    end_points: %W(#{current_uri}api/v1/people #{current_uri}api/v1/locations #{current_uri}api/v1/statuses),
                    homes: %w(https://github.com/Unisep/quebra-gelo-api http://quebra-gelo.strikingly.com/)
                }
        }
    respond_with @welcome
  end
end

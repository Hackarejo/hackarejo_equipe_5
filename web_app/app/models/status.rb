class Status < ActiveRecord::Base
  belongs_to :person

  validates :last_logged_at, presence: true
end

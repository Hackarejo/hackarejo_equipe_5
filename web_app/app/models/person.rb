class Person < ActiveRecord::Base
  has_one :location
  has_one :status

  validates :name, presence: true
  validates :user_id, presence: true
  validates_presence_of :phone, unless: :email?
  validates_presence_of :email, unless: :phone?
end

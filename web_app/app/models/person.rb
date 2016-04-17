class Person < ActiveRecord::Base
  devise :database_authenticatable, :registerable, :recoverable, 
  		 :rememberable, :trackable, :validatable

  validates :name, presence: true
  validates :user_id, presence: true
  
  validates_presence_of :phone, unless: :email?
  validates_presence_of :email, unless: :phone?
end
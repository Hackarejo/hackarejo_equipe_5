class Company < ActiveRecord::Base
  belongs_to :responsible, class_name: 'User', foreign_key: :responsible_id

  has_many :products
  has_many :offers
end

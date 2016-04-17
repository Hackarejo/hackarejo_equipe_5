class Company < ActiveRecord::Base
  belongs_to :responsible, class_name: 'Person', foreign_key: :responsible_id

  has_many :products
  has_many :offers

  mount_base64_uploader :image, ImageUploader
end

class Product < ActiveRecord::Base
  belongs_to :company

  mount_base64_uploader :image, ImageUploader
end

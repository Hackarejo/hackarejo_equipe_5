class ProductSerializer < ActiveModel::Serializer
  attributes :id, :name, :price
  
  has_one :company
end

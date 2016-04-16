class TagSerializer < ActiveModel::Serializer
  attributes :id, :name
  has_one :product
end

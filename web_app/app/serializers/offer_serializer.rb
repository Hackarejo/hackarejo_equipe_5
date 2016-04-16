class OfferSerializer < ActiveModel::Serializer
  attributes :id, :title, :description, :due_date
  
  has_one :company
end

class CompanySerializer < ActiveModel::Serializer
  attributes :id, :name, :phone, :latitude, :longitude
  
  has_one :responsible
end

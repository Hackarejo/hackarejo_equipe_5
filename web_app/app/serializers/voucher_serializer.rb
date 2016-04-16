class VoucherSerializer < ActiveModel::Serializer
  attributes :id, :code
  
  has_one :offer
end

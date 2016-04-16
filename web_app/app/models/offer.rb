class Offer < ActiveRecord::Base
  belongs_to :company

  has_one :voucher
end

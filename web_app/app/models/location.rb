class Location < ActiveRecord::Base
  belongs_to :person

  validates :latitude, presence: true
  validates :longitude, presence: true
end

module Api
  module V1
    class LocationsController < ApplicationController
      before_action :set_location, only: [:show, :update, :destroy]

      def index
        @locations = Location.all

        respond_with @locations
      end

      def show
        respond_with @location
      end

      def create
        @location = Location.new(location_params)
        @location.save

        respond_with :api, :v1, @location
      end

      def update
        @location.update(location_params)

        respond_with :api, :v1, @location
      end

      def destroy
        @location.destroy
        respond_with :api, :v1, @location
      end

      private

      def set_location
        @location = Location.find(params[:id])
      end

      def location_params
        params.require(:location).permit(:longitude, :latitude, :person_id)
      end
    end
  end
end

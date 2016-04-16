module Api
  module V1
    class StatusesController < ApplicationController
      before_action :set_status, only: [:show, :update, :destroy]

      def index
        @statuses = Status.all
        respond_with(@statuses)
      end

      def show
        respond_with(@status)
      end

      def create
        @status = Status.new(status_params)
        @status.save

        respond_with :api, :v1, @status
      end

      def update
        @status.update(status_params)
        respond_with :api, :v1, @status
      end

      def destroy
        @status.destroy
        respond_with :api, :v1, @status
      end

      private

      def set_status
        @status = Status.find(params[:id])
      end

      def status_params
        params.require(:status).permit(:last_logged_at, :person_id)
      end
    end
  end
end

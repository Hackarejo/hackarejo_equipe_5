module Api
  module V1
    class PeopleController < ApplicationController
      before_action :set_person, only: [:show, :update, :destroy]

      def index
        @people = Person.all

        respond_with(@people)
      end

      def show
        respond_with(@person)
      end

      def create
        @person = Person.new(person_params)
        @person.save

        respond_with :api, :v1, @person
      end

      def update
        @person.update(person_params)

        respond_with :api, :v1, @person
      end

      def destroy
        @person.destroy

        respond_with :api, :v1, @person
      end

      def find_by
        @person = Person.find_by(params[:hash])

        respond_with(@person)
      end

      private

      def set_person
        @person = Person.find(params[:id])
      end

      def person_params
        params.require(:person).permit :bio, :name, :email, :birthday_at, :phone,
                                       :user_id, :image, :fb_access_token, tags: []
      end
    end
  end
end

/**
 * @author Youngjae Lee
 * @version 2022-02-13
 *
 * description: Resource class
 */

package dmit2015.youngjaelee.assignment03.resource;


import common.JBean.BeanValidator;
import dmit2015.youngjaelee.assignment03.entity.OscarReview;
import dmit2015.youngjaelee.assignment03.repository.OscarReviewRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.OptimisticLockException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@ApplicationScoped
@Path("OscarReviews")                    // All methods of this class are associated this URL path
@Consumes(MediaType.APPLICATION_JSON)    // All methods this class accept only JSON format data
@Produces(MediaType.APPLICATION_JSON)    // All methods returns data that has been converted to JSON format
public class OscarReviewResource {

    @Inject
    private OscarReviewRepository _oscarReviewRepository;

    @GET    // This method only accepts HTTP GET requests.
    public Response listOscarReviews() {
        return Response.ok(_oscarReviewRepository.list()).build();
    }

    @Path("{id}")
    @GET    // This method only accepts HTTP GET requests.
    public Response findOscarReviewById(@PathParam("id") Long oscarReviewId) {
        OscarReview existingOscarReview = _oscarReviewRepository.findOptional(oscarReviewId).orElseThrow(NotFoundException::new);

        return Response.ok(existingOscarReview).build();
    }

    @POST    // This method only accepts HTTP POST requests.
    public Response addOscarReview(OscarReview newOscarReview, @Context UriInfo uriInfo) {

        String errorMessage = BeanValidator.validateBean(OscarReview.class, newOscarReview);
        if (errorMessage != null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(errorMessage)
                    .build();
        }

        try {
            // Persist the new OscarReviewDto into the database
            _oscarReviewRepository.create(newOscarReview);
        } catch (Exception ex) {
            // Return a HTTP status of "500 Internal Server Error" containing the exception message
            return Response.
                    serverError()
                    .entity(ex.getMessage())
                    .build();
        }

        // userInfo is injected via @Context parameter to this method
        URI location = uriInfo.getAbsolutePathBuilder()
                .path(newOscarReview.getId() + "")
                .build();

        // Set the location path of the new entity with its identifier
        // Returns an HTTP status of "201 Created" if the OscarReviewDto was successfully persisted
        return Response
                .created(location)
                .build();
    }

    @PUT            // This method only accepts HTTP PUT requests.
    @Path("{id}")    // This method accepts a path parameter and gives it a name of id
    public Response updateOscarReview(@PathParam("id") Long id, OscarReview updatedOscarReview) {
        if (!id.equals(updatedOscarReview.getId())) {
            throw new BadRequestException();
        }

        String errorMessage = BeanValidator.validateBean(OscarReview.class, updatedOscarReview);
        if (errorMessage != null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(errorMessage)
                    .build();
        }

        OscarReview existingOscarReview = _oscarReviewRepository
                .findOptional(id)
                .orElseThrow(NotFoundException::new);

        existingOscarReview.setCategory(updatedOscarReview.getCategory());

//        existingOscarReview.setNominee(updatedOscarReview.getNominee());

        existingOscarReview.setNominee(updatedOscarReview.getNominee());

        existingOscarReview.setReview(updatedOscarReview.getReview());

        existingOscarReview.setUsername(updatedOscarReview.getUsername());

        existingOscarReview.setVersion(updatedOscarReview.getVersion());

        try {
            _oscarReviewRepository.update(existingOscarReview);
        } catch (OptimisticLockException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("The data you are trying to update has changed since your last read request.")
                    .build();
        } catch (Exception ex) {
            // Return an HTTP status of "500 Internal Server Error" containing the exception message
            return Response.
                    serverError()
                    .entity(ex.getMessage())
                    .build();
        }

        return Response.ok(existingOscarReview).build();
    }

    @DELETE            // This method only accepts HTTP DELETE requests.
    @Path("{id}")    // This method accepts a path parameter and gives it a name of id
    public Response delete(@PathParam("id") Long id) {

        OscarReview existingOscarReview = _oscarReviewRepository
                .findOptional(id)
                .orElseThrow(NotFoundException::new);

        try {
            _oscarReviewRepository.remove(existingOscarReview);    // Removes the OscarReviewDto from being persisted
        } catch (Exception ex) {
            // Return a HTTP status of "500 Internal Server Error" containing the exception message
            return Response
                    .serverError()
                    .encoding(ex.getMessage())
                    .build();
        }

        // Returns an HTTP status "204 No Content" if the OscarReviewDto was successfully deleted
        return Response.noContent().build();
    }

}


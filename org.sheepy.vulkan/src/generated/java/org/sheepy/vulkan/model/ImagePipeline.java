/**
 */
package org.sheepy.vulkan.model;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.ImagePipeline#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImagePipeline#getImageSrcAccess <em>Image Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImagePipeline#getImageDstAccess <em>Image Dst Access</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getImagePipeline()
 * @model
 * @generated
 */
public interface ImagePipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(Image)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImagePipeline_Image()
	 * @model required="true"
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImagePipeline#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Image Src Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Src Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setImageSrcStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImagePipeline_ImageSrcStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getImageSrcStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getImageSrcStage()
	 * @generated
	 */
	void setImageSrcStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Image Dst Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Dst Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setImageDstStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImagePipeline_ImageDstStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getImageDstStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getImageDstStage()
	 * @generated
	 */
	void setImageDstStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Image Src Access</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Src Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Src Access</em>' attribute.
	 * @see #setImageSrcAccess(int)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImagePipeline_ImageSrcAccess()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getImageSrcAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImagePipeline#getImageSrcAccess <em>Image Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Src Access</em>' attribute.
	 * @see #getImageSrcAccess()
	 * @generated
	 */
	void setImageSrcAccess(int value);

	/**
	 * Returns the value of the '<em><b>Image Dst Access</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Dst Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Dst Access</em>' attribute.
	 * @see #setImageDstAccess(int)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImagePipeline_ImageDstAccess()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getImageDstAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImagePipeline#getImageDstAccess <em>Image Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Dst Access</em>' attribute.
	 * @see #getImageDstAccess()
	 * @generated
	 */
	void setImageDstAccess(int value);

} // ImagePipeline

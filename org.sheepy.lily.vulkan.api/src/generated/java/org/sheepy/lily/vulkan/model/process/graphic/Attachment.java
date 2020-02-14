/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getSamples <em>Samples</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getLoadOp <em>Load Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getStoreOp <em>Store Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getStencilLoadOp <em>Stencil Load Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getStencilStoreOp <em>Stencil Store Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getInitialLayout <em>Initial Layout</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getFinalLayout <em>Final Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment()
 * @model abstract="true"
 * @generated
 */
public interface Attachment extends LNamedElement, IImage
{
	/**
	 * Returns the value of the '<em><b>Samples</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ESampleCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Samples</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ESampleCount
	 * @see #setSamples(ESampleCount)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_Samples()
	 * @model unique="false"
	 * @generated
	 */
	ESampleCount getSamples();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getSamples <em>Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Samples</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ESampleCount
	 * @see #getSamples()
	 * @generated
	 */
	void setSamples(ESampleCount value);

	/**
	 * Returns the value of the '<em><b>Load Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
	 * @see #setLoadOp(EAttachmentLoadOp)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_LoadOp()
	 * @model unique="false"
	 * @generated
	 */
	EAttachmentLoadOp getLoadOp();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getLoadOp <em>Load Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
	 * @see #getLoadOp()
	 * @generated
	 */
	void setLoadOp(EAttachmentLoadOp value);

	/**
	 * Returns the value of the '<em><b>Store Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
	 * @see #setStoreOp(EAttachmentStoreOp)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_StoreOp()
	 * @model unique="false"
	 * @generated
	 */
	EAttachmentStoreOp getStoreOp();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getStoreOp <em>Store Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
	 * @see #getStoreOp()
	 * @generated
	 */
	void setStoreOp(EAttachmentStoreOp value);

	/**
	 * Returns the value of the '<em><b>Stencil Load Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stencil Load Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
	 * @see #setStencilLoadOp(EAttachmentLoadOp)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_StencilLoadOp()
	 * @model unique="false"
	 * @generated
	 */
	EAttachmentLoadOp getStencilLoadOp();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getStencilLoadOp <em>Stencil Load Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stencil Load Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
	 * @see #getStencilLoadOp()
	 * @generated
	 */
	void setStencilLoadOp(EAttachmentLoadOp value);

	/**
	 * Returns the value of the '<em><b>Stencil Store Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stencil Store Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
	 * @see #setStencilStoreOp(EAttachmentStoreOp)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_StencilStoreOp()
	 * @model unique="false"
	 * @generated
	 */
	EAttachmentStoreOp getStencilStoreOp();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getStencilStoreOp <em>Stencil Store Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stencil Store Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
	 * @see #getStencilStoreOp()
	 * @generated
	 */
	void setStencilStoreOp(EAttachmentStoreOp value);

	/**
	 * Returns the value of the '<em><b>Initial Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setInitialLayout(EImageLayout)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_InitialLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getInitialLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getInitialLayout <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getInitialLayout()
	 * @generated
	 */
	void setInitialLayout(EImageLayout value);

	/**
	 * Returns the value of the '<em><b>Final Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setFinalLayout(EImageLayout)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachment_FinalLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getFinalLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Attachment#getFinalLayout <em>Final Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getFinalLayout()
	 * @generated
	 */
	void setFinalLayout(EImageLayout value);

} // Attachment

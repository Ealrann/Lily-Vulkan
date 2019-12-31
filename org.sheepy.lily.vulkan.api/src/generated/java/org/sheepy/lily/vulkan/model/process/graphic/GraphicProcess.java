/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.maintainer.Maintainable;

import org.sheepy.lily.vulkan.model.process.AbstractProcess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getAttachmentPkg <em>Attachment Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getFieldOfViewY <em>Field Of View Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getSubpasses <em>Subpasses</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess()
 * @model
 * @generated
 */
public interface GraphicProcess extends AbstractProcess, Maintainable<GraphicProcess>
{
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(GraphicConfiguration)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_Configuration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GraphicConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(GraphicConfiguration value);

	/**
	 * Returns the value of the '<em><b>Attachment Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment Pkg</em>' containment reference.
	 * @see #setAttachmentPkg(AttachmentPkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_AttachmentPkg()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AttachmentPkg getAttachmentPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getAttachmentPkg <em>Attachment Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment Pkg</em>' containment reference.
	 * @see #getAttachmentPkg()
	 * @generated
	 */
	void setAttachmentPkg(AttachmentPkg value);

	/**
	 * Returns the value of the '<em><b>Field Of View Y</b></em>' attribute.
	 * The default value is <code>"45"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Of View Y</em>' attribute.
	 * @see #setFieldOfViewY(float)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_FieldOfViewY()
	 * @model default="45" unique="false"
	 * @generated
	 */
	float getFieldOfViewY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getFieldOfViewY <em>Field Of View Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Of View Y</em>' attribute.
	 * @see #getFieldOfViewY()
	 * @generated
	 */
	void setFieldOfViewY(float value);

	/**
	 * Returns the value of the '<em><b>Subpasses</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.Subpass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpasses</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicProcess_Subpasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subpass> getSubpasses();

} // GraphicProcess

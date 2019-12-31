/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subpass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAttachmantRefPkg <em>Attachmant Ref Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSubpassIndex <em>Subpass Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getStages <em>Stages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAccesses <em>Accesses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getBindPoint <em>Bind Point</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getScenePart <em>Scene Part</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass()
 * @model
 * @generated
 */
public interface Subpass extends IResourceContainer, LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Attachmant Ref Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachmant Ref Pkg</em>' containment reference.
	 * @see #setAttachmantRefPkg(AttachmentRefPkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_AttachmantRefPkg()
	 * @model containment="true"
	 * @generated
	 */
	AttachmentRefPkg getAttachmantRefPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getAttachmantRefPkg <em>Attachmant Ref Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachmant Ref Pkg</em>' containment reference.
	 * @see #getAttachmantRefPkg()
	 * @generated
	 */
	void setAttachmantRefPkg(AttachmentRefPkg value);

	/**
	 * Returns the value of the '<em><b>Subpass Index</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpass Index</em>' attribute.
	 * @see #setSubpassIndex(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_SubpassIndex()
	 * @model default="0" unique="false" required="true"
	 * @generated
	 */
	int getSubpassIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getSubpassIndex <em>Subpass Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subpass Index</em>' attribute.
	 * @see #getSubpassIndex()
	 * @generated
	 */
	void setSubpassIndex(int value);

	/**
	 * Returns the value of the '<em><b>Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_Stages()
	 * @model
	 * @generated
	 */
	EList<EPipelineStage> getStages();

	/**
	 * Returns the value of the '<em><b>Accesses</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accesses</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_Accesses()
	 * @model
	 * @generated
	 */
	EList<EAccess> getAccesses();

	/**
	 * Returns the value of the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #setPipelinePkg(PipelinePkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_PipelinePkg()
	 * @model containment="true"
	 * @generated
	 */
	PipelinePkg getPipelinePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getPipelinePkg <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipeline Pkg</em>' containment reference.
	 * @see #getPipelinePkg()
	 * @generated
	 */
	void setPipelinePkg(PipelinePkg value);

	/**
	 * Returns the value of the '<em><b>Bind Point</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Point</em>' attribute.
	 * @see #setBindPoint(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_BindPoint()
	 * @model default="0" unique="false" required="true"
	 * @generated
	 */
	int getBindPoint();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getBindPoint <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Point</em>' attribute.
	 * @see #getBindPoint()
	 * @generated
	 */
	void setBindPoint(int value);

	/**
	 * Returns the value of the '<em><b>Scene Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scene Part</em>' reference.
	 * @see #setScenePart(IScenePart)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSubpass_ScenePart()
	 * @model
	 * @generated
	 */
	IScenePart getScenePart();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getScenePart <em>Scene Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene Part</em>' reference.
	 * @see #getScenePart()
	 * @generated
	 */
	void setScenePart(IScenePart value);

} // Subpass

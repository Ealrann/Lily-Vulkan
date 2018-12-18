/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;

import org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl;

import org.sheepy.vulkan.model.resource.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageSrcStage <em>Image Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageDstStage <em>Image Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageSrcAccess <em>Image Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageDstAccess <em>Image Dst Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImagePipelineImpl extends AbstractPipelineImpl implements ImagePipeline
{
	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected Image image;

	/**
	 * The default value of the '{@link #getImageSrcStage() <em>Image Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage IMAGE_SRC_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getImageSrcStage() <em>Image Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage imageSrcStage = IMAGE_SRC_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageDstStage() <em>Image Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage IMAGE_DST_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getImageDstStage() <em>Image Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage imageDstStage = IMAGE_DST_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageSrcAccess() <em>Image Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int IMAGE_SRC_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getImageSrcAccess() <em>Image Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected int imageSrcAccess = IMAGE_SRC_ACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageDstAccess() <em>Image Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int IMAGE_DST_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getImageDstAccess() <em>Image Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstAccess()
	 * @generated
	 * @ordered
	 */
	protected int imageDstAccess = IMAGE_DST_ACCESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImagePipelineImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.IMAGE_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image getImage()
	{
		if (image != null && image.eIsProxy())
		{
			InternalEObject oldImage = (InternalEObject)image;
			image = (Image)eResolveProxy(oldImage);
			if (image != oldImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.IMAGE_PIPELINE__IMAGE, oldImage, image));
			}
		}
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image basicGetImage()
	{
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImage(Image newImage)
	{
		Image oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getImageSrcStage()
	{
		return imageSrcStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageSrcStage(EPipelineStage newImageSrcStage)
	{
		EPipelineStage oldImageSrcStage = imageSrcStage;
		imageSrcStage = newImageSrcStage == null ? IMAGE_SRC_STAGE_EDEFAULT : newImageSrcStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE, oldImageSrcStage, imageSrcStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getImageDstStage()
	{
		return imageDstStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageDstStage(EPipelineStage newImageDstStage)
	{
		EPipelineStage oldImageDstStage = imageDstStage;
		imageDstStage = newImageDstStage == null ? IMAGE_DST_STAGE_EDEFAULT : newImageDstStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE, oldImageDstStage, imageDstStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getImageSrcAccess()
	{
		return imageSrcAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageSrcAccess(int newImageSrcAccess)
	{
		int oldImageSrcAccess = imageSrcAccess;
		imageSrcAccess = newImageSrcAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS, oldImageSrcAccess, imageSrcAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getImageDstAccess()
	{
		return imageDstAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageDstAccess(int newImageDstAccess)
	{
		int oldImageDstAccess = imageDstAccess;
		imageDstAccess = newImageDstAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS, oldImageDstAccess, imageDstAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				if (resolve) return getImage();
				return basicGetImage();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				return getImageSrcStage();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				return getImageDstStage();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS:
				return getImageSrcAccess();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS:
				return getImageDstAccess();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				setImage((Image)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				setImageSrcStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				setImageDstStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS:
				setImageSrcAccess((Integer)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS:
				setImageDstAccess((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				setImage((Image)null);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				setImageSrcStage(IMAGE_SRC_STAGE_EDEFAULT);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				setImageDstStage(IMAGE_DST_STAGE_EDEFAULT);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS:
				setImageSrcAccess(IMAGE_SRC_ACCESS_EDEFAULT);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS:
				setImageDstAccess(IMAGE_DST_ACCESS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				return image != null;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				return imageSrcStage != IMAGE_SRC_STAGE_EDEFAULT;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				return imageDstStage != IMAGE_DST_STAGE_EDEFAULT;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS:
				return imageSrcAccess != IMAGE_SRC_ACCESS_EDEFAULT;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS:
				return imageDstAccess != IMAGE_DST_ACCESS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (imageSrcStage: ");
		result.append(imageSrcStage);
		result.append(", imageDstStage: ");
		result.append(imageDstStage);
		result.append(", imageSrcAccess: ");
		result.append(imageSrcAccess);
		result.append(", imageDstAccess: ");
		result.append(imageDstAccess);
		result.append(')');
		return result.toString();
	}

} //ImagePipelineImpl
